package com.virtualcode7ecuadorvigitrack.auditorioespoch.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedFace;
import com.google.ar.core.AugmentedImage;
import com.google.ar.core.Config;
import com.google.ar.core.Frame;
import com.google.ar.core.Pose;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.SceneView;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.CustomArFragment;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.CustomArGFragment;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.CustomArLogoFragment;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.R;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.EnumSet;

public class GraduateActivity extends AppCompatActivity implements Scene.OnUpdateListener
{
    private CustomArGFragment mCustomArLogoFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduate);
        mCustomArLogoFragment  = (CustomArGFragment)
                getSupportFragmentManager().findFragmentById(R.id.id_fragment_graduate);

        mCustomArLogoFragment.getArSceneView().getScene().addOnUpdateListener(this);
    }


    @Override
    protected void onPostResume() 
    {

        super.onPostResume();
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
                if (image.getName().equals("imagedificio"))
                {
                    /*Anchor mAnchor = image.createAnchor(image.getCenterPose());
                    createModel(mAnchor);*/

                    Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                    sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=http://vigitrackecuador.com/service_mbf/auditorio.glb"));
                    sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                    startActivity(sceneViewerIntent);

                }
            }
        }
    }

    private void createModel(Anchor mAnchor)
    {
        ModelRenderable.builder()
                .setSource(GraduateActivity.this, Uri.parse("auditoriofie.sfb"))
                .build().thenAccept(modelRenderable -> placemodel(modelRenderable,mAnchor));
    }

    private void placemodel(ModelRenderable modelRenderable, Anchor mAnchor)
    {
        AnchorNode mAnchorNode = new AnchorNode(mAnchor);
        mAnchorNode.setRenderable(modelRenderable);
        mCustomArLogoFragment.getArSceneView().getScene().addChild(mAnchorNode);
    }

}