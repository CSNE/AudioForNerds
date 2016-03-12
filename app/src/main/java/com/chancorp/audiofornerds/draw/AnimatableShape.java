//Licensed under the MIT License.
//Include the license text thingy if you're gonna use this.
//Copyright (c) 2016 Chansol Yang

package com.chancorp.audiofornerds.draw;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

import com.chancorp.audiofornerds.animation.MixedProperties;
import com.chancorp.audiofornerds.animation.PointsCompound;
import com.chancorp.audiofornerds.animation.PropertySet;

public class AnimatableShape extends Animatable{

    PointsCompound path;

    Matrix mat;

    int color;

    /*
    Required Properties:
    x
    y
    scale
    rotation
    alpha
     */

    public AnimatableShape(PointsCompound path, int color, MixedProperties basisSet){
        super(basisSet);

        this.path =path;
        this.color=color;
    }

    private PointsCompound getPointsCompound(long currentTime){
        PropertySet ps= mixedProperties.update(currentTime);

        mat=new Matrix();
        mat.preTranslate(ps.getValue("X"), ps.getValue("Y"));
        mat.preRotate(ps.getValue("Rotation"));
        mat.preScale(ps.getValue("Scale"), ps.getValue("Scale"));

        return path.transform(mat);
    }

    public RectF getBounds(float padding,long currentTime){
        return getPointsCompound(currentTime).getBounds(padding);
    }

    @Override
    public void draw(Canvas c, Paint pt, long currentTime){
        PropertySet ps= mixedProperties.update(currentTime);

        mat=new Matrix();
        mat.preTranslate(ps.getValue("X"), ps.getValue("Y"));
        mat.preRotate(ps.getValue("Rotation"));
        mat.preScale(ps.getValue("Scale"), ps.getValue("Scale"));

        pt.setColor(color);
        pt.setAlpha(Math.round(255 * ps.getValue("Alpha")));
        //Log2.log(2,this,path);
        c.drawPath(path.transform(mat).toPath(),pt);
        pt.setAlpha(255);
    }


}
