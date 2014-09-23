/**
 * 
 */
package org.mwc.cmap.plotViewer.actions;


import org.mwc.cmap.core.CorePlugin;
import org.mwc.cmap.core.operations.DebriefActionWrapper;

import MWC.GUI.PlainChart;
import MWC.GUI.Tools.Action;
import MWC.GenericData.WorldArea;

/**
 * @author ian.mayo
 *
 */
public class FitToWindow extends CoreEditorAction
{
	protected void execute()
	{
		final PlainChart theChart = getChart();

		final WorldArea oldArea = new WorldArea(theChart.getCanvas().getProjection().getVisibleDataArea());
		final Action theAction = 	new MWC.GUI.Tools.Chart.FitToWin.FitToWinAction(theChart, oldArea);
		
		// and wrap it
		final DebriefActionWrapper daw = new DebriefActionWrapper(theAction, theChart.getLayers(), null);
		
		// and add it to the clipboard
		CorePlugin.run(daw);
	
	}

	
}