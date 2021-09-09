package ru.irlix.evaluation.repository.estimation;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import ru.irlix.evaluation.dao.entity.Estimation;
import ru.irlix.evaluation.dto.request.EstimationFilterRequest;
import ru.irlix.evaluation.dto.request.EstimationFindAnyRequest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EstimationFilterRepositoryImpl implements EstimationFilterRepository {

    private final EntityManager manager;
    private CriteriaBuilder builder;
    private CriteriaQuery<Estimation> query;
    private Root<Estimation> root;

    @Override
    public Page<Estimation> filter(EstimationFilterRequest request) {
        builder = manager.getCriteriaBuilder();
        query = builder.createQuery(Estimation.class);
        root = query.from(Estimation.class);
        return findPageableEstimations(request.getPage(), request.getSize(), getPredicate(request));
    }

    @Override
    public Page<Estimation> findAny(EstimationFindAnyRequest request) {
        builder = manager.getCriteriaBuilder();
        query = builder.createQuery(Estimation.class);
        root = query.from(Estimation.class);
        return findPageableEstimations(request.getPage(), request.getSize(), getPredicate(request));
    }

    private Page<Estimation> findPageableEstimations(Integer page, Integer size, Predicate predicate) {
        int offset = page * size;

        query.select(root)
                .where(predicate)
                .orderBy(builder.desc(root.get("createDate")));

        TypedQuery<Estimation> typedQuery = manager.createQuery(query);
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(size);

        return new PageImpl<>(
                typedQuery.getResultList(),
                PageRequest.of(page, size),
                getTotalCount(predicate)
        );
    }

    private Predicate getPredicate(EstimationFilterRequest request) {
        List<Predicate> filterPredicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(request.getName())) {
            filterPredicates.add(builder.like(builder.lower(root.get("name")), "%" + request.getName().toLowerCase() + "%"));
        }

        if (StringUtils.isNotEmpty(request.getClient())) {
            filterPredicates.add(builder.like(builder.lower(root.get("client")), "%" + request.getClient().toLowerCase() + "%"));
        }

        if (StringUtils.isNotEmpty(request.getCreator())) {
            filterPredicates.add(builder.like(builder.lower(root.get("creator")), "%" + request.getCreator().toLowerCase() + "%"));
        }

        if (request.getStatus() != null) {
            filterPredicates.add(builder.equal(root.get("status").get("id"), request.getStatus()));
        }

        if (request.getBeginDate() != null) {
            filterPredicates.add(builder.greaterThanOrEqualTo(root.get("createDate"), request.getBeginDate()));
        }

        if (request.getEndDate() != null) {
            filterPredicates.add(builder.lessThanOrEqualTo(root.get("createDate"), request.getEndDate()));
        }

        return builder.and(filterPredicates.toArray(new Predicate[0]));
    }

    private Predicate getPredicate(EstimationFindAnyRequest request) {
        List<Predicate> textPredicates = new ArrayList<>();
        List<Predicate> otherPredicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(request.getText())) {
            textPredicates.add(builder.like(builder.lower(root.get("name")), "%" + request.getText().toLowerCase() + "%"));
            textPredicates.add(builder.like(builder.lower(root.get("client")), "%" + request.getText().toLowerCase() + "%"));
            textPredicates.add(builder.like(builder.lower(root.get("creator")), "%" + request.getText().toLowerCase() + "%"));
        }

        if (request.getStatus() != null) {
            otherPredicates.add(builder.equal(root.get("status").get("id"), request.getStatus()));
        }

        if (request.getBeginDate() != null) {
            otherPredicates.add(builder.greaterThanOrEqualTo(root.get("createDate"), request.getBeginDate()));
        }

        if (request.getEndDate() != null) {
            otherPredicates.add(builder.lessThanOrEqualTo(root.get("createDate"), request.getEndDate()));
        }

        return builder.and(
                textPredicates.isEmpty() ? builder.and() : builder.or(textPredicates.toArray(new Predicate[0])),
                builder.and(otherPredicates.toArray(new Predicate[0]))
        );
    }

    private Long getTotalCount(Predicate filterPredicate) {
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(Estimation.class)));
        countQuery.where(filterPredicate);

        return manager.createQuery(countQuery).getSingleResult();
    }
}
