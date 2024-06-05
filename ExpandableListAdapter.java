package edu.dayton.entertainmentguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context; // Context of the application/activity
    private List<String> groupTitles; // List of group/category titles
    private HashMap<String, List<String>> childItems; // HashMap mapping group titles to lists of child items

    // Constructor to initialize the adapter with data
    public ExpandableListAdapter(Context context, List<String> groupTitles, HashMap<String, List<String>> childItems) {
        this.context = context;
        this.groupTitles = groupTitles;
        this.childItems = childItems;
    }

    @Override
    public int getGroupCount() {
        return groupTitles.size(); // Return the number of groups/categories
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String groupTitle = groupTitles.get(groupPosition); // Get the title of the specific group
        List<String> childList = childItems.get(groupTitle); // Get the list of child items for the group
        return childList != null ? childList.size() : 0; // Return the number of child items for the group
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTitles.get(groupPosition); // Return the title of the specific group
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String groupTitle = groupTitles.get(groupPosition); // Get the title of the specific group
        List<String> childList = childItems.get(groupTitle); // Get the list of child items for the group
        return childList != null ? childList.get(childPosition) : null; // Return the specific child item from the group
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition; // Return the ID of the specific group
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition; // Return the ID of the specific child item within the group
    }

    @Override
    public boolean hasStableIds() {
        return true; // Specifies that the group and child IDs are stable (not changing) over time
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition); // Get the title of the specific group

        if (convertView == null) {
            // If the view for the group does not exist, inflate it using the layout inflater
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView tvGroupTitle = convertView.findViewById(R.id.tvGroupTitle); // Get the TextView for the group title
        tvGroupTitle.setText(groupTitle); // Set the group title to the TextView

        return convertView; // Return the group view
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childItem = (String) getChild(groupPosition, childPosition); // Get the specific child item

        if (convertView == null) {
            // If the view for the child item does not exist, inflate it using the layout inflater
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView tvChildItem = convertView.findViewById(R.id.tvChildItem); // Get the TextView for the child item
        tvChildItem.setText(childItem); // Set the child item to the TextView

        return convertView; // Return the child item view
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true; // Specifies that child items are selectable
    }
}

