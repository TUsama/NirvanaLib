package com.clefal.nirvana_lib.client.lang;

import java.util.List;
import java.util.function.Supplier;

public interface ILangEntry {
    Supplier<List<LangPair>> provide();
}
