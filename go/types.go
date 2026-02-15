// Package colorsimilarity provides a Go client for the Color Similarity Calculator API.
//
// For more information, visit: https://apiverve.com/marketplace/colorsimilarity?utm_source=go&utm_medium=readme
package colorsimilarity

import (
	"fmt"
	"reflect"
	"regexp"
	"strings"
)

// ValidationRule defines validation constraints for a parameter.
type ValidationRule struct {
	Type      string
	Required  bool
	Min       *float64
	Max       *float64
	MinLength *int
	MaxLength *int
	Format    string
	Enum      []string
}

// ValidationError represents a parameter validation error.
type ValidationError struct {
	Errors []string
}

func (e *ValidationError) Error() string {
	return "Validation failed: " + strings.Join(e.Errors, "; ")
}

// Helper functions for pointers
func float64Ptr(v float64) *float64 { return &v }
func intPtr(v int) *int             { return &v }

// Format validation patterns
var formatPatterns = map[string]*regexp.Regexp{
	"email":    regexp.MustCompile(`^[^\s@]+@[^\s@]+\.[^\s@]+$`),
	"url":      regexp.MustCompile(`^https?://.+`),
	"ip":       regexp.MustCompile(`^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$`),
	"date":     regexp.MustCompile(`^\d{4}-\d{2}-\d{2}$`),
	"hexColor": regexp.MustCompile(`^#?([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$`),
}

// Request contains the parameters for the Color Similarity Calculator API.
//
// Parameters:
//   - color1 (required): string - First hex color value (with or without # prefix) [format: hexColor]
//   - color2 (required): string - Second hex color value (with or without # prefix) [format: hexColor]
type Request struct {
	Color1 string `json:"color1"` // Required
	Color2 string `json:"color2"` // Required
}

// ToQueryParams converts the request struct to a map of query parameters.
// Only non-zero values are included.
func (r *Request) ToQueryParams() map[string]string {
	params := make(map[string]string)
	if r == nil {
		return params
	}

	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		// Get the json tag for the field name
		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		// Handle tags like `json:"name,omitempty"`
		jsonName := strings.Split(jsonTag, ",")[0]
		if jsonName == "-" {
			continue
		}

		// Skip zero values
		if field.IsZero() {
			continue
		}

		// Convert to string
		params[jsonName] = fmt.Sprintf("%v", field.Interface())
	}

	return params
}

// Validate checks the request parameters against validation rules.
// Returns a ValidationError if validation fails, nil otherwise.
func (r *Request) Validate() error {
	rules := map[string]ValidationRule{
		"color1": {Type: "string", Required: true, Format: "hexColor"},
		"color2": {Type: "string", Required: true, Format: "hexColor"},
	}

	if len(rules) == 0 {
		return nil
	}

	var errors []string
	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		jsonName := strings.Split(jsonTag, ",")[0]

		rule, exists := rules[jsonName]
		if !exists {
			continue
		}

		// Check required
		if rule.Required && field.IsZero() {
			errors = append(errors, fmt.Sprintf("Required parameter [%s] is missing", jsonName))
			continue
		}

		if field.IsZero() {
			continue
		}

		// Type-specific validation
		switch rule.Type {
		case "integer", "number":
			var numVal float64
			switch field.Kind() {
			case reflect.Int, reflect.Int64:
				numVal = float64(field.Int())
			case reflect.Float64:
				numVal = field.Float()
			}
			if rule.Min != nil && numVal < *rule.Min {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %v", jsonName, *rule.Min))
			}
			if rule.Max != nil && numVal > *rule.Max {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %v", jsonName, *rule.Max))
			}

		case "string":
			strVal := field.String()
			if rule.MinLength != nil && len(strVal) < *rule.MinLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %d characters", jsonName, *rule.MinLength))
			}
			if rule.MaxLength != nil && len(strVal) > *rule.MaxLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %d characters", jsonName, *rule.MaxLength))
			}
			if rule.Format != "" {
				if pattern, ok := formatPatterns[rule.Format]; ok {
					if !pattern.MatchString(strVal) {
						errors = append(errors, fmt.Sprintf("Parameter [%s] must be a valid %s", jsonName, rule.Format))
					}
				}
			}
		}

		// Enum validation
		if len(rule.Enum) > 0 {
			strVal := fmt.Sprintf("%v", field.Interface())
			found := false
			for _, enumVal := range rule.Enum {
				if strVal == enumVal {
					found = true
					break
				}
			}
			if !found {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be one of: %s", jsonName, strings.Join(rule.Enum, ", ")))
			}
		}
	}

	if len(errors) > 0 {
		return &ValidationError{Errors: errors}
	}
	return nil
}

// ResponseData contains the data returned by the Color Similarity Calculator API.
type ResponseData struct {
	Color1 Color1Data `json:"color1"`
	Color2 Color2Data `json:"color2"`
	RgbDistance float64 `json:"rgb_distance"`
	RgbSimilarity float64 `json:"rgb_similarity"`
	HslSimilarity float64 `json:"hsl_similarity"`
	OverallSimilarity float64 `json:"overall_similarity"`
	DeltaE float64 `json:"delta_e"`
	HueDifference float64 `json:"hue_difference"`
	SaturationDifference int `json:"saturation_difference"`
	LightnessDifference float64 `json:"lightness_difference"`
	SimilarityCategory string `json:"similarity_category"`
	AreIdentical bool `json:"are_identical"`
}

// Color1Data represents the color1 object.
type Color1Data struct {
	Hex string `json:"hex"`
	Rgb RgbData `json:"rgb"`
	Hsl HslData `json:"hsl"`
}

// RgbData represents the rgb object.
type RgbData struct {
	R int `json:"r"`
	G int `json:"g"`
	B int `json:"b"`
}

// HslData represents the hsl object.
type HslData struct {
	H float64 `json:"h"`
	S int `json:"s"`
	L int `json:"l"`
}

// Color2Data represents the color2 object.
type Color2Data struct {
	Hex string `json:"hex"`
	Rgb RgbData `json:"rgb"`
	Hsl HslData `json:"hsl"`
}

// RgbData represents the rgb object.
type RgbData struct {
	R int `json:"r"`
	G int `json:"g"`
	B int `json:"b"`
}

// HslData represents the hsl object.
type HslData struct {
	H float64 `json:"h"`
	S int `json:"s"`
	L float64 `json:"l"`
}
