package org.mwc.debrief.track_shift.ambiguity.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants
{
  public static final String MIN_ZIG = "CutOff";
  
  /** whether to output slicing diagnostics
   * 
   */
  public static final String DIAGNOSTICS = "OutputDiagnostics";
  
  /** whether to display slicing UI controls
   * 
   */
  public static final String DISPLAY = "ShowControls";

  /** minimum rate at which both bearings travel in SAME DIRECTION
   * (workaround for problem in up-stream processing system)
   * 
   */
  public static final String MIN_TURN_RATE = "MinTurnRate";
  
  /** minimum length of period of cuts to treat them as steady
   * 
   */
  public static final String MIN_LEG_LENGTH = "MinLegLength";
  
}