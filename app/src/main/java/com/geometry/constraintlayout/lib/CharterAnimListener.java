package com.geometry.constraintlayout.lib;

public interface CharterAnimListener {
  void onAnimStart();

  void onAnimFinish();

  void onAnimCancel();

  void onAnimProgress(float progress);
}
