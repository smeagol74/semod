package ru.kvb74.utils;

import java.util.*;
import java.util.logging.Logger;

public class CombinedResourceBundle extends ResourceBundle {

    private static Logger log = Logger.getLogger(CombinedResourceBundle.class.getName());

    private Map<String, String> combinedResources = new HashMap<>();
    private List<String> bundleNames;

    public CombinedResourceBundle(List<String> bundleNames) {
        this.bundleNames = bundleNames;
    }

    public void load(boolean raiseErrors) {
        bundleNames.forEach(bundleName ->
        {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
                Enumeration<String> keysEnumeration = bundle.getKeys();
                ArrayList<String> keysList = Collections.list(keysEnumeration);
                keysList.forEach(key -> combinedResources.put(key, bundle.getString(key)));
            } catch (Exception ex) {
                if (raiseErrors) {
                    throw(ex);
                } else {
                    log.warning(ex.getMessage());
                }
            }
        });
    }

    @Override
    public Object handleGetObject(String key) {
        return combinedResources.get(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return Collections.enumeration(combinedResources.keySet());
    }
}