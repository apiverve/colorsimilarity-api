# Color Similarity Calculator API

Color Similarity Calculator is a tool for calculating similarity between two colors. It uses multiple algorithms including RGB distance, HSL comparison, and Delta E to provide comprehensive color similarity analysis.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Javascript Wrapper for the [Color Similarity Calculator API](https://apiverve.com/marketplace/colorsimilarity)

---

## Installation

Using npm:
```shell
npm install @apiverve/colorsimilarity
```

Using yarn:
```shell
yarn add @apiverve/colorsimilarity
```

---

## Configuration

Before using the Color Similarity Calculator API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart)

The Color Similarity Calculator API documentation is found here: [https://docs.apiverve.com/ref/colorsimilarity](https://docs.apiverve.com/ref/colorsimilarity).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const colorsimilarityAPI = require('@apiverve/colorsimilarity');
const api = new colorsimilarityAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  color1: "FF5733",
  color2: "FF6B47"
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  color1: "FF5733",
  color2: "FF6B47"
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  color1: "FF5733",
  color2: "FF6B47"
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}
```

---

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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
