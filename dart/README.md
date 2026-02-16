# Color Similarity Calculator API - Dart/Flutter Client

Color Similarity Calculator is a tool for calculating similarity between two colors. It uses multiple algorithms including RGB distance, HSL comparison, and Delta E to provide comprehensive color similarity analysis.

[![pub package](https://img.shields.io/pub/v/apiverve_colorsimilarity.svg)](https://pub.dev/packages/apiverve_colorsimilarity)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Color Similarity Calculator API](https://apiverve.com/marketplace/colorsimilarity?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_colorsimilarity: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_colorsimilarity/apiverve_colorsimilarity.dart';

void main() async {
  final client = ColorsimilarityClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'color1': 'FF5733',
      'color2': 'FF6B47'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Color Similarity Calculator API](https://apiverve.com/marketplace/colorsimilarity?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/colorsimilarity](https://docs.apiverve.com/ref/colorsimilarity?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
