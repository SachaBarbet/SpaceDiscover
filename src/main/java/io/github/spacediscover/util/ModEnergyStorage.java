package io.github.spacediscover.util;

import net.minecraftforge.energy.EnergyStorage;

public abstract class ModEnergyStorage extends EnergyStorage {

    public ModEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int receiveEnergy = super.receiveEnergy(maxReceive, simulate);
        if (receiveEnergy != 0){
            onChanged();
        }

        return receiveEnergy;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extractEnergy = super.extractEnergy(maxExtract, simulate);
        if (extractEnergy != 0){
            onChanged();
        }

        return extractEnergy;
    }

    public int setEnergy(int energy) {
        if (energy != this.energy) {
            this.energy = energy;
        }

        return energy;
    }

    public void onChanged() {
    }
}
