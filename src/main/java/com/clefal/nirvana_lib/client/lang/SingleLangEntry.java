package com.clefal.nirvana_lib.client.lang;

import lombok.Builder;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;


public class SingleLangEntry implements ILangEntry{
    private final LangPair main;

    private SingleLangEntry(LangPair main) {
        this.main = main;
    }

    public MutableComponent get() {
        return MutableComponent.create(new TranslatableContents(main.getKey(), null, TranslatableContents.NO_ARGS));
    }

    public MutableComponent get(Object... args) {
        return MutableComponent.create(new TranslatableContents(main.getKey(), null, args));
    }

    @Override
    public Supplier<List<LangPair>> provide() {
        return () -> List.of(main);
    }

    public static final class SingleLangEntryBuilder {
        private String modId;
        private List<String> categories;
        private String keySuffix;
        private String value;

        public SingleLangEntryBuilder(String modId, List<String> categories) {
            this.modId = modId;
            this.categories = categories;
        }


        public SingleLangEntryBuilder lang(String keySuffix, String value) {
            this.keySuffix = keySuffix;
            this.value = value;
            return this;
        }

        public SingleLangEntry build() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(modId);
            for (String category : categories) {
                stringBuilder.append(".").append(category);
            }
            stringBuilder.append(".").append(keySuffix);
            SingleLangEntry singleLangEntry = new SingleLangEntry(LangPair.of(stringBuilder.toString(), value));
            LangCreator.entries.add(singleLangEntry);
            return singleLangEntry;
        }
    }
}
