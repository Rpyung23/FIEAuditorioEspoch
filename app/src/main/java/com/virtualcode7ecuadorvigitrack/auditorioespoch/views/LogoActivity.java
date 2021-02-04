package com.virtualcode7ecuadorvigitrack.auditorioespoch.views;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.core.Frame;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.*;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.R;

import java.util.Collection;

public class LogoActivity extends AppCompatActivity implements Scene.OnUpdateListener
{
    private CustomArLogoFragment mCustomArLogoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        mCustomArLogoFragment  = (CustomArLogoFragment)
                getSupportFragmentManager().findFragmentById(R.id.id_fragment_logo);

        mCustomArLogoFragment.getArSceneView().getScene().addOnUpdateListener(this);

    }

    @Override
    public void onUpdate(FrameTime frameTime)
    {
        Frame frame = mCustomArLogoFragment.getArSceneView().getArFrame();
        Collection<AugmentedImage> mAugmentedImages = frame.getUpdatedTrackables(AugmentedImage.class);
        for (AugmentedImage image : mAugmentedImages)
        {
            if (image.getTrackingState() == TrackingState.TRACKING)
            {
                if (image.getName().equals("imagelogo"))
                {
                    Anchor mAnchor = image.createAnchor(image.getCenterPose());
                    createModel(mAnchor);
                }
            }
        }
    }

    private void createModel(Anchor mAnchor)
    {
        ModelRenderable.builder()
                .setSource(LogoActivity.this, Uri.parse("fieauditorio.sfb"))
                .build().thenAccept(modelRenderable -> placemodel(modelRenderable,mAnchor));
    }

    private void placemodel(ModelRenderable modelRenderable, Anchor mAnchor)
    {
        AnchorNode mAnchorNode = new AnchorNode(mAnchor);
        mAnchorNode.setRenderable(modelRenderable);
        mCustomArLogoFragment.getArSceneView().getScene().addChild(mAnchorNode);
    }
}