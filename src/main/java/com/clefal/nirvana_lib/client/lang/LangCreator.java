package com.clefal.nirvana_lib.client.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LangCreator {

    final String modId;
    final List<String> categories = new ArrayList<>();
    public final static List<ILangEntry> entries = new ArrayList<>();

    public LangCreator(String modId) {
        this.modId = modId;
    }

    public SingleLangEntry.SingleLangEntryBuilder single(){
        return new SingleLangEntry.SingleLangEntryBuilder(modId, categories);
    }

    public WithDescLangEntry.WithDescLangEntryBuilder withDesc(){
        return new WithDescLangEntry.WithDescLangEntryBuilder(modId, categories);
    }

    public LangCreator categories(String... categories){
        this.categories.addAll(Arrays.asList(categories));
        return this;
    }

    public LangCreator categories(String category){
        this.categories.add(category);
        return this;
    }
}
