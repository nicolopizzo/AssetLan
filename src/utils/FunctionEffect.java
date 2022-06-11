package utils;

import java.util.ArrayList;

public class FunctionEffect extends Effect {
    private ArrayList<String> localAssets;
    private ArrayList<String> globalAssets;
    private EffectsEnvironment sigma0;
    private EffectsEnvironment sigma1;

    public FunctionEffect(ArrayList<String> localAssets, ArrayList<String> globalAssets, EffectsEnvironment sigma0, EffectsEnvironment sigma1) {
        this.localAssets = localAssets;
        this.globalAssets = globalAssets;
        this.sigma0 = sigma0;
        this.sigma1 = sigma1;
    }

    public FunctionEffect(EffectsEnvironment sigma0, EffectsEnvironment sigma1) {
        this.sigma0 = sigma0;
        this.sigma1 = sigma1;
    }

    public ArrayList<String> getLocalAssets() {
        return localAssets;
    }

    public ArrayList<String> getGlobalAssets() {
        return globalAssets;
    }

    public EffectsEnvironment getSigma0() {
        return sigma0;
    }

    public EffectsEnvironment getSigma1() {
        return sigma1;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FunctionEffect)) {
            return false;
        }

        EffectsEnvironment sigma2 = ((FunctionEffect) obj).getSigma1();

        for (String a : localAssets) {
            if (sigma1.getEffect(a) != sigma2.getEffect(a)) {
                return false;
            }
        }

        for (String a : globalAssets) {
            if (sigma1.getEffect(a) != sigma2.getEffect(a)) {
                return false;
            }
        }

        return true;
    }

    public void updateSigma1(EffectsEnvironment sigma1) {
        this.sigma1 = sigma1;
    }
}
