# Color Similarity Calculator API - Ruby Gem

Color Similarity Calculator measures color similarity between two hex values. It returns an overall similarity score, a categorical match rating, and RGB and HSL channel breakdowns, while paid plans add Delta E and color distance metrics.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_colorsimilarity'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_colorsimilarity
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_colorsimilarity'

# Initialize the client
client = APIVerve::Colorsimilarity::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  color1: "FF5733",
  color2: "FF6B47"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ color1: "FF5733", color2: "FF6B47" })
  puts response["data"]
rescue APIVerve::Colorsimilarity::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Colorsimilarity::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Colorsimilarity::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "color1": {
      "hex": "#FF5733",
      "rgb": {
        "r": 255,
        "g": 87,
        "b": 51
      },
      "hsl": {
        "h": 10.6,
        "s": 100,
        "l": 60
      }
    },
    "color2": {
      "hex": "#FF6B47",
      "rgb": {
        "r": 255,
        "g": 107,
        "b": 71
      },
      "hsl": {
        "h": 11.7,
        "s": 100,
        "l": 63.9
      }
    },
    "rgb_distance": 28.28,
    "rgb_similarity": 93.6,
    "hsl_similarity": 97.71,
    "overall_similarity": 95.65,
    "delta_e": 28.28,
    "hue_difference": 1.15,
    "saturation_difference": 0,
    "lightness_difference": 3.92,
    "similarity_category": "nearly identical",
    "are_identical": false
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/colorsimilarity?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/colorsimilarity?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/colorsimilarity?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
