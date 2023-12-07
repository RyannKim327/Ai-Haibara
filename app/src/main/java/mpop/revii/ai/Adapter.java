package mpop.revii.ai;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {
	Context ctx;
	ArrayList<String> list;
	public Adapter(Context context, ArrayList arraylist){
		super(context, util.setResources(context, "layout_list", "layout"), arraylist);
		ctx = context;
		list = arraylist;
	}
}
