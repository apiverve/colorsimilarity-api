declare module '@apiverve/colorsimilarity' {
  export interface colorsimilarityOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface colorsimilarityResponse {
    status: string;
    error: string | null;
    data: ColorSimilarityCalculatorData;
    code?: number;
  }


  interface ColorSimilarityCalculatorData {
      color1:               Color;
      color2:               Color;
      rgbDistance:          number;
      rgbSimilarity:        number;
      hslSimilarity:        number;
      overallSimilarity:    number;
      deltaE:               number;
      hueDifference:        number;
      saturationDifference: number;
      lightnessDifference:  number;
      similarityCategory:   string;
      areIdentical:         boolean;
  }
  
  interface Color {
      hex: string;
      rgb: RGB;
      hsl: Hsl;
  }
  
  interface Hsl {
      h: number;
      s: number;
      l: number;
  }
  
  interface RGB {
      r: number;
      g: number;
      b: number;
  }

  export default class colorsimilarityWrapper {
    constructor(options: colorsimilarityOptions);

    execute(callback: (error: any, data: colorsimilarityResponse | null) => void): Promise<colorsimilarityResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: colorsimilarityResponse | null) => void): Promise<colorsimilarityResponse>;
    execute(query?: Record<string, any>): Promise<colorsimilarityResponse>;
  }
}
