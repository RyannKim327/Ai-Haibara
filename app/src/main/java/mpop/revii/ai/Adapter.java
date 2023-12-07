package mpop.revii.ai;

import android.content.Context;
import android.graphics.Color;
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
	public Adapter(Context context, ArrayList arraylist){
		super(context, util.setResources(context, "layout_list", "layout"), arraylist);
		ctx = context;
		list = arraylist;
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
		}else{
			base.setBackgroundColor(Color.LTGRAY);
		}
		number.setText(String.valueOf(position + 1));
		code.setText(data);

		return layout;
	}
}
