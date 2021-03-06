//Licensed under the MIT License.
//Include the license text thingy if you're gonna use this.
//Copyright (c) 2016 Chansol Yang

package com.cosmicsubspace.nerdyaudio.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cosmicsubspace.nerdyaudio.R;
import com.cosmicsubspace.nerdyaudio.audio.Waveform;

public class AutoGainFilter extends BaseFilter {
    private static final String LOG_TAG = "CS_AFN";
    Waveform wf;

    public AutoGainFilter(FilterManager fm) {
        super(fm);
        wf = Waveform.getInstance();
    }

    private float getGain() {
        //Log2.log(1,this,"Peak:"+wf.getPeak());
        return 32767.0f / wf.getPeak();
    }

    @Override
    public void filter(float[] data) {
        if (wf.isReady()) {
            float gain = getGain();
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i] * gain;
            }
        }
        //If not, don't do anything...
    }

    @Override
    public String getName() {
        return "Auto Gain";
    }

    @Override
    public View getContentView(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.filter_auto_gain, container, false);
        return v;
    }

}
