package mpop.revii.ai;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
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
	public Adapter(Context context, ArrayList<String> languages, ArrayList<String> arraylist){
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
		float f = 8f;
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));

		if((position % 2) == 0){
			sd.getPaint().setColor(Color.DKGRAY);
			number.setTextColor(Color.WHITE);
			code.setTextColor(Color.WHITE);
		}else{
			sd.getPaint().setColor(Color.LTGRAY);
			number.setTextColor(Color.BLACK);
			code.setTextColor(Color.BLACK);
		}

		base.setBackground(sd);
		number.setText(String.format("[%d]: %s Code", position + 1, lang.get(position)));
		code.setText(list.get(position));
		number.setTypeface(Typeface.SERIF);
		code.setTypeface(Typeface.MONOSPACE);

		return layout;
	}
	@Override
	public String getItem(int position){
		return getItem(position);
	}
}
