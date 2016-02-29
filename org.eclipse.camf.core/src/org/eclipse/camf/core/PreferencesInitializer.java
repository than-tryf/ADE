package org.eclipse.camf.core;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import org.eclipse.camf.core.internal.Activator;


public class PreferencesInitializer extends AbstractPreferenceInitializer {

  /**
   * Initializes the eu.celar.core.prefs file with the registered Cloud providers' details.
   */
  @Override
  public void initializeDefaultPreferences() {
    org.eclipse.core.runtime.Preferences preferenceStore = null;
    Activator activator = Activator.getDefault();
    if ( activator != null ) {
      preferenceStore = activator.getPluginPreferences();
    }
    
    String providerString = "[{\"port\":\"8080\",\"name\":\"Okeanos\",\"uri\":\"http://83.212.122.157\"} ]";
    preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providerString);
    //preferenceStore.setDefault( PreferenceConstants.DEFINED_CPS_ID, providerString);
  }
}
