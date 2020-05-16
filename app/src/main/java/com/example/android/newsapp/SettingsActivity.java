package com.example.android.newsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class NewsPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener  {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            Preference chooseTopStory = findPreference(getString(R.string.settings_top_story_key));
            bindPreferenceSummaryToValue(chooseTopStory);

        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            // The code in this method takes care of updating the displayed preference summary after it has been changed
            String stringValue = newValue.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);}
            return true;
        }

        //This method takes in a preference as its parameters,
        // and we use setOnPreferenceChangeListener to set the current EarthquakePreferenceFragment
        // instance to listen for changes to the preferences we pass in using:
        private void bindPreferenceSummaryToValue(Preference topStoryPreference) {
            topStoryPreference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(topStoryPreference.getContext());
            String minMagnitudeUsersInput = preferences.getString(topStoryPreference.getKey(), "");
            onPreferenceChange(topStoryPreference, minMagnitudeUsersInput);
        }
    }

}



