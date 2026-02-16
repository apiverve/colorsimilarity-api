/// Response models for the Color Similarity Calculator API.

/// API Response wrapper.
class ColorsimilarityResponse {
  final String status;
  final dynamic error;
  final ColorsimilarityData? data;

  ColorsimilarityResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory ColorsimilarityResponse.fromJson(Map<String, dynamic> json) => ColorsimilarityResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ColorsimilarityData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Color Similarity Calculator API.

class ColorsimilarityData {
  ColorsimilarityDataColor1? color1;
  ColorsimilarityDataColor2? color2;
  double? rgbDistance;
  double? rgbSimilarity;
  double? hslSimilarity;
  double? overallSimilarity;
  double? deltaE;
  double? hueDifference;
  int? saturationDifference;
  double? lightnessDifference;
  String? similarityCategory;
  bool? areIdentical;

  ColorsimilarityData({
    this.color1,
    this.color2,
    this.rgbDistance,
    this.rgbSimilarity,
    this.hslSimilarity,
    this.overallSimilarity,
    this.deltaE,
    this.hueDifference,
    this.saturationDifference,
    this.lightnessDifference,
    this.similarityCategory,
    this.areIdentical,
  });

  factory ColorsimilarityData.fromJson(Map<String, dynamic> json) => ColorsimilarityData(
      color1: json['color1'] != null ? ColorsimilarityDataColor1.fromJson(json['color1']) : null,
      color2: json['color2'] != null ? ColorsimilarityDataColor2.fromJson(json['color2']) : null,
      rgbDistance: json['rgb_distance'],
      rgbSimilarity: json['rgb_similarity'],
      hslSimilarity: json['hsl_similarity'],
      overallSimilarity: json['overall_similarity'],
      deltaE: json['delta_e'],
      hueDifference: json['hue_difference'],
      saturationDifference: json['saturation_difference'],
      lightnessDifference: json['lightness_difference'],
      similarityCategory: json['similarity_category'],
      areIdentical: json['are_identical'],
    );
}

class ColorsimilarityDataColor1 {
  String? hex;
  ColorsimilarityDataColor1Rgb? rgb;
  ColorsimilarityDataColor1Hsl? hsl;

  ColorsimilarityDataColor1({
    this.hex,
    this.rgb,
    this.hsl,
  });

  factory ColorsimilarityDataColor1.fromJson(Map<String, dynamic> json) => ColorsimilarityDataColor1(
      hex: json['hex'],
      rgb: json['rgb'] != null ? ColorsimilarityDataColor1Rgb.fromJson(json['rgb']) : null,
      hsl: json['hsl'] != null ? ColorsimilarityDataColor1Hsl.fromJson(json['hsl']) : null,
    );
}

class ColorsimilarityDataColor1Rgb {
  int? r;
  int? g;
  int? b;

  ColorsimilarityDataColor1Rgb({
    this.r,
    this.g,
    this.b,
  });

  factory ColorsimilarityDataColor1Rgb.fromJson(Map<String, dynamic> json) => ColorsimilarityDataColor1Rgb(
      r: json['r'],
      g: json['g'],
      b: json['b'],
    );
}

class ColorsimilarityDataColor1Hsl {
  double? h;
  int? s;
  int? l;

  ColorsimilarityDataColor1Hsl({
    this.h,
    this.s,
    this.l,
  });

  factory ColorsimilarityDataColor1Hsl.fromJson(Map<String, dynamic> json) => ColorsimilarityDataColor1Hsl(
      h: json['h'],
      s: json['s'],
      l: json['l'],
    );
}

class ColorsimilarityDataColor2 {
  String? hex;
  ColorsimilarityDataColor2Rgb? rgb;
  ColorsimilarityDataColor2Hsl? hsl;

  ColorsimilarityDataColor2({
    this.hex,
    this.rgb,
    this.hsl,
  });

  factory ColorsimilarityDataColor2.fromJson(Map<String, dynamic> json) => ColorsimilarityDataColor2(
      hex: json['hex'],
      rgb: json['rgb'] != null ? ColorsimilarityDataColor2Rgb.fromJson(json['rgb']) : null,
      hsl: json['hsl'] != null ? ColorsimilarityDataColor2Hsl.fromJson(json['hsl']) : null,
    );
}

class ColorsimilarityDataColor2Rgb {
  int? r;
  int? g;
  int? b;

  ColorsimilarityDataColor2Rgb({
    this.r,
    this.g,
    this.b,
  });

  factory ColorsimilarityDataColor2Rgb.fromJson(Map<String, dynamic> json) => ColorsimilarityDataColor2Rgb(
      r: json['r'],
      g: json['g'],
      b: json['b'],
    );
}

class ColorsimilarityDataColor2Hsl {
  double? h;
  int? s;
  double? l;

  ColorsimilarityDataColor2Hsl({
    this.h,
    this.s,
    this.l,
  });

  factory ColorsimilarityDataColor2Hsl.fromJson(Map<String, dynamic> json) => ColorsimilarityDataColor2Hsl(
      h: json['h'],
      s: json['s'],
      l: json['l'],
    );
}

class ColorsimilarityRequest {
  String color1;
  String color2;

  ColorsimilarityRequest({
    required this.color1,
    required this.color2,
  });

  Map<String, dynamic> toJson() => {
      'color1': color1,
      'color2': color2,
    };
}
