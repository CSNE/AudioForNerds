//Licensed under the MIT License.
//Include the license text thingy if you're gonna use this.
//Copyright (c) 2016 Chansol Yang

package com.chancorp.audiofornerds.interfaces;

import com.chancorp.audiofornerds.file.MusicInformation;

import java.util.ArrayList;

public interface FileListReturnListener {
    void onReturn(ArrayList<MusicInformation> files);
}
