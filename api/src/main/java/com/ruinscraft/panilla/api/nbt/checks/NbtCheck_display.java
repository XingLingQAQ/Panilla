package com.ruinscraft.panilla.api.nbt.checks;

import com.ruinscraft.panilla.api.IProtocolConstants;
import com.ruinscraft.panilla.api.config.PConfig;
import com.ruinscraft.panilla.api.config.PStrictness;
import com.ruinscraft.panilla.api.nbt.INbtTagCompound;

public class NbtCheck_display extends NbtCheck {

	public NbtCheck_display() {
		super("display", PStrictness.AVERAGE);
	}

	@Override
	public boolean check(INbtTagCompound tag, String nmsItemClassName, IProtocolConstants protocolConstants, PConfig config) {
		INbtTagCompound display = tag.getCompound(getName());

		String name = display.getString("name");

		if (name != null && name.length() > protocolConstants.maxAnvilRenameChars()) {
			return false;
		}

		return true;
	}

}