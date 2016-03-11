package com.vnlotus.easybooking.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CommonUtils {
  private static NumberFormat nf;
  private static final String pattern = "###,###.###";
  private static DecimalFormat df;

  static {
    nf = NumberFormat.getNumberInstance(new Locale("vi"));
    df = (DecimalFormat)nf;
    df.applyPattern(pattern);
  }

  public static String getDotNumberStyle(float value) {
    return df.format(value);
  }
}
