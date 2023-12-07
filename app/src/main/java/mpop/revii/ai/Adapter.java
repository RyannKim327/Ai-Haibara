package mpop.revii.ai;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class Adapter extends ArrayAdapter<String> {
	Context ctx;
	ArrayList<String> list;
	ArrayList<String> lang;
	public Adapter(Context context, ArrayList languages, ArrayList arraylist){
		super(context, util.setResources(context, "layout_list", "layout"), arraylist);
		ctx = context;
		list = arraylist;
		lang = languages;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View layout = LayoutInflater.from(ctx).inflate(util.setResources(ctx, "layout_list", "layout"), null, false);
		LinearLayout base = layout.findViewById(util.setResources(ctx, "baseLayout", "id"));
		TextView number = layout.findViewById(util.setResources(ctx, "number", "id"));
		TextView code = layout.findViewById(util.setResources(ctx, "code", "id"));
		String data = list.get(position);

		if((position % 2) == 0){
			base.setBackgroundColor(Color.DKGRAY);
			number.setTextColor(Color.WHITE);
			code.setTextColor(Color.WHITE);
		}else{
			base.setBackgroundColor(Color.LTGRAY);
			number.setTextColor(Color.BLACK);
			code.setTextColor(Color.BLACK);
		}

		number.setText(String.format("[%d]: %s", position + 1, lang.get(position)));
		code.setText(data);
		number.setTypeface(Typeface.SANS_SERIF);
		code.setTypeface(Typeface.SERIF);

		return layout;
	}
}
