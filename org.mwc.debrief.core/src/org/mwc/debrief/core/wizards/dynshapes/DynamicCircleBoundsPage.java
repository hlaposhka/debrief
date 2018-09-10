/**
 * 
 */
package org.mwc.debrief.core.wizards.dynshapes;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.mwc.cmap.core.custom_widget.CWorldLocation;
import org.mwc.cmap.core.custom_widget.LocationModifiedListener;
import org.mwc.cmap.core.custom_widget.LocationModifiedEvent;
import org.mwc.debrief.core.wizards.sensorarc.NewSensorArcBaseWizardPage;

import MWC.GenericData.WorldLocation;

/**
 * @author Ayesha
 *
 */
public class DynamicCircleBoundsPage extends NewSensorArcBaseWizardPage
{

  private CWorldLocation _txtCentre;
  private Text _txtRadius;
  protected DynamicCircleBoundsPage(String pageName)
  {
    super(pageName);
    setTitle("Create Dynamic Circle");
    setDescription("This wizard is used to create dynamic shapes");
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createControl(Composite parent)
  {
    Composite mainComposite = new Composite(parent,SWT.NULL);
    mainComposite.setLayout(new GridLayout());
    mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
    Composite baseComposite = super.createBaseControl(mainComposite);
    Composite composite = new Composite(baseComposite,SWT.NULL);
    composite.setLayout(new GridLayout(2,false));
    composite.setLayoutData(new GridData(GridData.FILL_BOTH));
    GridData gd = new GridData(SWT.BEGINNING,SWT.CENTER,true,false);
    gd.minimumWidth=125;
    new Label(composite,SWT.NONE).setText("Centre:");
    _txtCentre = new CWorldLocation(composite,SWT.NONE);
    _txtCentre.setLayoutData(gd);
    _txtCentre.setToolTipText("Location of centre of the dynamic circle");
    _txtCentre.addLocationModifiedListener(new LocationModifiedListener()
    {
      
      @Override
      public void modifyValue(LocationModifiedEvent e)
      {
        setPageComplete(isPageComplete());
        
      }
    });
    new Label(composite,SWT.NONE).setText("Radius: ");
    _txtRadius = new Text(composite,SWT.BORDER);
    _txtRadius.setToolTipText("Radius of the dynamic circle");
    
    _txtRadius.setLayoutData(gd);
    _txtRadius.addModifyListener(new ModifyListener()
    {
      
      @Override
      public void modifyText(ModifyEvent e)
      {
        setPageComplete(isPageComplete());
      }
    });
    setControl(mainComposite);
  }

  public WorldLocation getCenter()
  {
    return (WorldLocation)_txtCentre.getValue();
  }
  public int getRadius()
  {
    return Integer.valueOf(_txtRadius.getText());
  }
  @Override
  public boolean isPageComplete()
  {
    if(!_txtRadius.getText().isEmpty() && isValidRadius(_txtRadius.getText())) {
      return true;
    }
    return false;
  }
  
  private boolean isValidRadius(String value) {
    //radius must be integer in the range 0 to 4000.
    if(!value.matches("\\\\d+")){
      int num = Integer.valueOf(value);
      if(num>0 && num<=4000) {
        return true;
      }
    }
    return false;
  }

}
