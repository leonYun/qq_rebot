package com.leon.project.qqRobot.template;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class BatchPageLoadTemplate<Q extends Pageable, D> {
    private Pageable page;

    public BatchPageLoadTemplate(Pageable pageable) {
        this.page = pageable;
    }

    public Iterator<D> execute() {
        return new Iterator<D>() {
            Iterator<D> iterator;
            @Override
            public boolean hasNext() {
                if (Objects.isNull(iterator) || !iterator.hasNext()) {
                    List<D> data = query(page);
                    page = PageRequest.of(page.getPageNumber() + 1, page.getPageSize());
                    if (CollectionUtils.isEmpty(data)) {
                        return false;
                    }
                    iterator = data.iterator();
                }
                return iterator.hasNext();
            }

            @Override
            public D next() {
                return iterator.next();
            }
        };
    }

    protected abstract List<D> query(Pageable page);
}
