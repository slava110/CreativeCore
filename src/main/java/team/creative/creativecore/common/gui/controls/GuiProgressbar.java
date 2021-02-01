package team.creative.creativecore.common.gui.controls;

import com.mojang.blaze3d.matrix.MatrixStack;

import team.creative.creativecore.client.render.GuiRenderHelper;
import team.creative.creativecore.common.gui.GuiControl;
import team.creative.creativecore.common.gui.style.ControlFormatting;
import team.creative.creativecore.common.gui.style.GuiStyle;
import team.creative.creativecore.common.gui.tooltip.TooltipBuilder;
import team.creative.creativecore.common.util.math.Rect;

public class GuiProgressbar extends GuiControl {
	
	public double pos;
	public double max;
	public boolean showToolTip = true;
	
	public GuiProgressbar(String name, int x, int y, int width, int height, double pos, double max) {
		super(name, x, y, width, height);
		this.pos = pos;
		this.max = max;
	}
	
	@Override
	public void init() {}
	
	@Override
	public void closed() {}
	
	@Override
	public void tick() {}
	
	@Override
	public String getToolTip() {
		if (showToolTip)
			return new TooltipBuilder().append(pos, true).append("/").append(max, true).append(" (").append(pos / max * 100, true).append("%)").build();
		return null;
	}
	
	@Override
	public ControlFormatting getControlFormatting() {
		return ControlFormatting.PROGRESSBAR;
	}
	
	@Override
	protected void renderContent(MatrixStack matrix, Rect rect, int mouseX, int mouseY) {
		GuiStyle style = getStyle();
		double percent = pos / max;
		style.clickable.render(matrix, 0, 0, (int) (rect.getWidth() * percent), rect.getHeight());
		GuiRenderHelper.drawStringCentered(matrix, ((int) Math.round(percent * 100)) + "%", rect.getWidth(), rect.getHeight(), style.fontColor.toInt(), true);
	}
	
}
