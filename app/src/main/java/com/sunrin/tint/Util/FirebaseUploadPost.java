package com.sunrin.tint.Util;

import android.content.Context;
import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sunrin.tint.Model.PostModel;
import com.sunrin.tint.Model.UserModel;

import java.util.List;

public class FirebaseUploadPost {

    public interface OnUploadSuccessListener {
        void onUploadSuccess();
    }

    public interface OnUploadFailureListener {
        void onUploadFailed(String errorMsg);
    }

    public static void UploadPost(Context context, PostModel postModel, OnUploadSuccessListener s, OnUploadFailureListener f) {

        UserModel userModel = UserCache.getUser(context);
        postModel.setUserName(userModel.getName());
        postModel.setUserEmail(userModel.getEmail());

        FirebaseFirestore
                .getInstance()
                .collection("posts")
                .document(postModel.getId())
                .set(postModel)
                .addOnSuccessListener(command -> s.onUploadSuccess())
                .addOnFailureListener(e -> f.onUploadFailed(FirebaseErrorUtil.getErrorMessage(e, "업로드에 실패하였습니다.")));
    }
}
