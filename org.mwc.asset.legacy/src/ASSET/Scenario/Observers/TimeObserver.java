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
package ASSET.Scenario.Observers;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.Vector;

import ASSET.ScenarioType;
import ASSET.Util.SupportTesting;
import MWC.Algorithms.LiveData.DataDoublet;
import MWC.Algorithms.LiveData.IAttribute;
import MWC.GUI.Editable;


/** controller observer that stops running after indicated period
 * 
 * @author ianmayo
 *
 */
public class TimeObserver extends
  CoreObserver implements ASSET.Scenario.ScenarioSteppedListener, IAttribute
{
  /***************************************************************
   *  member variables
   ***************************************************************/

  /***************************************************************
   *  constructor
   ***************************************************************/
  /**
   * default constructor - doesn't need much
   *
   */
  public TimeObserver()
  {
    super("Time", true);
  }


  /**
   * ************************************************************
   * member methods
   * *************************************************************
   */

  /**
   * we're getting up and running.  The observers have been created and we've remembered
   * the scenario
   *
   * @param scenario the new scenario we're looking at
   */
  protected void performSetupProcessing(ScenarioType scenario)
  {
  }

  /**
   * right, the scenario is about to close.  We haven't removed the listeners
   * or forgotten the scenario (yet).
   *
   * @param scenario the scenario we're closing from
   */
  protected void performCloseProcessing(ScenarioType scenario)
  {

  }

  /**
   * add any applicable listeners
   */
  protected void addListeners(ScenarioType scenario)
  {
    // and become a listener
    _myScenario.addScenarioSteppedListener(this);
  }

  /**
   * remove any listeners
   */
  protected void removeListeners(ScenarioType scenario)
  {
    // remove ourselves as a listener
    _myScenario.removeScenarioSteppedListener(this);
  }

  /**
   * the scenario has stepped forward
   */
  public void step(ScenarioType scenario, final long newTime)
  {
  	getAttributeHelper().newData(scenario, newTime,new Date(newTime));
  }


  //////////////////////////////////////////////////
  // property editing
  //////////////////////////////////////////////////

  private EditorType _myEditor1;

  /**
   * whether there is any edit information for this item
   * this is a convenience function to save creating the EditorType data
   * first
   *
   * @return yes/no
   */
  public boolean hasEditor()
  {
    return true;
  }

  /**
   * get the editor for this item
   *
   * @return the BeanInfo data for this editable object
   */
  public EditorType getInfo()
  {
    if (_myEditor1 == null)
      _myEditor1 = new TimeObserverInfo(this);

    return _myEditor1;
  }

  //////////////////////////////////////////////////
  // editable properties
  //////////////////////////////////////////////////
  static public class TimeObserverInfo extends EditorType
  {


    /**
     * constructor for editable details
     *
     * @param data the object we're going to edit
     */
    public TimeObserverInfo(final TimeObserver data)
    {
      super(data, data.getName(), "Edit");
    }

    /**
     * editable GUI properties for our participant
     *
     * @return property descriptions
     */
    public PropertyDescriptor[] getPropertyDescriptors()
    {
      try
      {
        final PropertyDescriptor[] res = {
          prop("Name", "the name of this observer"),
        };
        return res;
      }
      catch (IntrospectionException e)
      {
        e.printStackTrace();
        return super.getPropertyDescriptors();
      }
    }
  }

  //////////////////////////////////////////////////
  // property testing
  //////////////////////////////////////////////////
  public static class TimeObsTest extends SupportTesting.EditableTesting
  {
    /**
     * get an object which we can test
     *
     * @return Editable object which we can check the properties for
     */
    public Editable getEditable()
    {
      return new TimeObserver();
    }
  }

  public DataDoublet getCurrent(Object index)
	{
		return getAttributeHelper().getCurrent(index);
	}

  public Vector<DataDoublet> getHistoricValues(Object index)
	{
		return getAttributeHelper().getValuesFor(index);
	}

	public boolean isSignificant()
	{
		return true;
	}


	public String getUnits()
	{
		
		return "n/a";
	}


}
