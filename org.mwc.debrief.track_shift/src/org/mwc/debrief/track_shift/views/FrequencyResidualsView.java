/*
 *    Debrief - the Open Source Maritime Analysis Application
 *    http://debrief.info
 *
 *    (C) 2000-2014, PlanetMayo Ltd
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the Eclipse Public License v1.0
 *    (http://www.eclipse.org/legal/epl-v10.html)
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 */
package org.mwc.debrief.track_shift.views;

import org.mwc.debrief.track_shift.controls.ZoneChart.ColorProvider;
import org.mwc.debrief.track_shift.controls.ZoneChart.ZoneSlicer;

public class FrequencyResidualsView extends BaseStackedDotsView
{
  public FrequencyResidualsView()
  {
    super(false, true);
  }

  protected String getUnits()
  {
    return "Hz";
  }

  protected String getType()
  {
    return "Frequency";
  }

  protected void updateData(final boolean updateDoublets)
  {
    // update the current datasets
    _myHelper.updateFrequencyData(_dotPlot, _linePlot, _myTrackDataProvider,
        _onlyVisible.isChecked(), _holder, this, updateDoublets);
  }

  @Override
  protected ZoneSlicer getOwnshipZoneSlicer(ColorProvider blueProv)
  {
    // don't bother, it's for bearing data
    return null;
  }
  
  @Override
  protected String formatValue(double value)
  {
    return MWC.Utilities.TextFormatting.GeneralFormat
        .formatTwoDecimalPlaces(value);
  }

  @Override
  protected boolean allowDisplayOfTargetOverview()
  {
    return false;
  }

  @Override
  protected boolean allowDisplayOfZoneChart()
  {
    return false;
  }

}
