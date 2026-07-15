declare module '@apiverve/colorsimilarity' {
  export interface colorsimilarityOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface colorsimilarityResponse {
    status: string;
    error: string | null;
    data: ColorSimilarityCalculatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface ColorSimilarityCalculatorData {
      color1:               Color;
      color2:               Color;
      rgbDistance:          number | null;
      rgbSimilarity:        number | null;
      hslSimilarity:        number | null;
      overallSimilarity:    number | null;
      deltaE:               number | null;
      hueDifference:        number | null;
      saturationDifference: number | null;
      lightnessDifference:  number | null;
      similarityCategory:   null | string;
      areIdentical:         boolean | null;
  }
  
  interface Color {
      hex: null | string;
      rgb: RGB;
      hsl: Hsl;
  }
  
  interface Hsl {
      h: number | null;
      s: number | null;
      l: number | null;
  }
  
  interface RGB {
      r: number | null;
      g: number | null;
      b: number | null;
  }

  export default class colorsimilarityWrapper {
    constructor(options: colorsimilarityOptions);

    execute(callback: (error: any, data: colorsimilarityResponse | null) => void): Promise<colorsimilarityResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: colorsimilarityResponse | null) => void): Promise<colorsimilarityResponse>;
    execute(query?: Record<string, any>): Promise<colorsimilarityResponse>;
  }
}
