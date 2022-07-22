package com.slyvr.api.generator;

import java.util.List;

public interface TieredGenerator extends ItemGenerator {

    List<GeneratorTier> getTiers();

    GeneratorTier getCurrentTier();

    void setCurrentTier(int tier);

    Resource getDrop();

}