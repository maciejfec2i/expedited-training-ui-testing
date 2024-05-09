package com.expeditedtraining.uitesting.user.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TextEditor {

   private boolean isEnabled;

   public TextEditor(boolean isEnabled) {
       this.isEnabled = isEnabled;
   }

   public static TextEditor fontStyle(String fontStyle) {
      return new TextEditor(true);
   }
}
