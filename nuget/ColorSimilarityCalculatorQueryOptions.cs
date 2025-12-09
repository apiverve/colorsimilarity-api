using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.ColorSimilarityCalculator
{
    /// <summary>
    /// Query options for the Color Similarity Calculator API
    /// </summary>
    public class ColorSimilarityCalculatorQueryOptions
    {
        /// <summary>
        /// First hex color value (with or without # prefix)
        /// Example: FF5733
        /// </summary>
        [JsonProperty("color1")]
        public string Color1 { get; set; }

        /// <summary>
        /// Second hex color value (with or without # prefix)
        /// Example: FF6B47
        /// </summary>
        [JsonProperty("color2")]
        public string Color2 { get; set; }
    }
}
