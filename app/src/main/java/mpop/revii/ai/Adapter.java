package mpop.revii.ai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {
	Context ctx;
	ArrayList<String> list;
	public Adapter(Context context, ArrayList arraylist){
		super(context, util.setResources(context, "layout_list", "layout"), arraylist);
		ctx = context;
		list = arraylist;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout layout = LayoutInflater.from(ctx).inflate(util.setResources(ctx, "layout_list", "layout"), false);
		return super.getView(position, convertView, parent);
	}
}
