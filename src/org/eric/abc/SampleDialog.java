package org.eric.abc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SampleDialog extends BlurDialogFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		View customView = getActivity().getLayoutInflater().inflate(
				R.layout.dialog_fragment, null);
//		TextView label = ((TextView) customView.findViewById(R.id.textView));
//		label.setMovementMethod(LinkMovementMethod.getInstance());
//		Linkify.addLinks(label, Linkify.WEB_URLS);
		builder.setView(customView);
		return builder.create();
	}

}
