# Color Similarity Calculator API - PHP Package

Color Similarity Calculator is a tool for calculating similarity between two colors. It uses multiple algorithms including RGB distance, HSL comparison, and Delta E to provide comprehensive color similarity analysis.

## Installation

Install via Composer:

```bash
composer require apiverve/colorsimilarity
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Colorsimilarity\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'color1' => 'FF5733',
    'color2' => 'FF6B47'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Colorsimilarity\Client;
use APIVerve\Colorsimilarity\Exceptions\APIException;
use APIVerve\Colorsimilarity\Exceptions\ValidationException;

try {
    $response = $client->execute(['color1' => 'FF5733', 'color2' => 'FF6B47']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/colorsimilarity?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/colorsimilarity?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/colorsimilarity?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
