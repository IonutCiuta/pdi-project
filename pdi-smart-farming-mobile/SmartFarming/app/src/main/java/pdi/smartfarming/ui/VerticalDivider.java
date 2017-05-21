package pdi.smartfarming.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ionutciuta24@gmail.com on 20.05.2017.
 */

public class VerticalDivider extends RecyclerView.ItemDecoration{
    private final int verticalSpaceHeight;

    public VerticalDivider(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    public VerticalDivider() {
        this.verticalSpaceHeight = 16;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }
}
