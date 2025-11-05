package com.clefal.nirvana_lib.client.lang;


import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WithDescLangEntry implements ILangEntry{
    private final LangPair main;
    private final List<LangPair> descs;

    private WithDescLangEntry(LangPair main, List<LangPair> descs) {
        this.main = main;
        this.descs = descs;
    }

    public MutableComponent get() {
        return MutableComponent.create(new TranslatableContents(main.getKey(), null, TranslatableContents.NO_ARGS));
    }

    public MutableComponent get(Object... args) {
        return MutableComponent.create(new TranslatableContents(main.getKey(), null, args));
    }

    public MutableComponent getDesc(int index) {
        return MutableComponent.create(new TranslatableContents(descs.get(index).getKey(), null, TranslatableContents.NO_ARGS));
    }

    public MutableComponent getDesc(int index, Object... args) {
        return MutableComponent.create(new TranslatableContents(descs.get(index).getKey(), null, args));
    }

    public List<MutableComponent> getAllDesc(){
        ArrayList<MutableComponent> mutableComponents = new ArrayList<>();
        for (LangPair desc : descs) {
            mutableComponents.add(MutableComponent.create(new TranslatableContents(desc.getKey(), null, TranslatableContents.NO_ARGS)));
        }
        return mutableComponents;
    }

    @Override
    public Supplier<List<LangPair>> provide() {
        return () -> {
            List<LangPair> main1 = List.of(main);
            main1.addAll(descs);
            return main1;
        };
    }

    public static final class WithDescLangEntryBuilder {
        private String modId;
        private List<String> categories;
        private String keySuffix;
        private String value;
        private List<String> descsValue;
        private String descSuffix;

        public WithDescLangEntryBuilder(String modId, List<String> categories) {
            this.modId = modId;
            this.categories = categories;
            this.descsValue = new ArrayList<>();
        }


        public WithDescLangEntryBuilder lang(String keySuffix, String value) {
            this.keySuffix = keySuffix;
            this.value = value;
            return this;
        }

        public WithDescLangEntryBuilder desc(String value) {
            this.descsValue.add(value);
            return this;
        }

        public WithDescLangEntryBuilder defaultDescSuffix(){
            this.descSuffix = "desc";
            return this;
        }

        public WithDescLangEntry build() {
            StringBuilder base = new StringBuilder();
            base.append(modId);
            for (String category : categories) {
                base.append(".").append(category);
            }
            String baseKey = base.toString();
            StringBuilder mainKey = base.append(".").append(keySuffix);
            ArrayList<LangPair> descs = new ArrayList<>();

            for (int i = 0; i < descsValue.size(); i++) {
                descs.add(LangPair.of(baseKey + "." + descSuffix + "." + i + 1, descsValue.get(i)));
            }
            WithDescLangEntry withDescLangEntry = new WithDescLangEntry(LangPair.of(mainKey.toString(), value), descs);
            LangCreator.entries.add(withDescLangEntry);
            return withDescLangEntry;
        }
    }
}
