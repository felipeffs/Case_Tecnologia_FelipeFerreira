package com.felipeferreiradasilva.service;

import com.felipeferreiradasilva.domain.Meta;
import com.felipeferreiradasilva.domain.enumeration.AreaEnem;
import com.felipeferreiradasilva.repository.MetaRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.felipeferreiradasilva.domain.Meta}.
 */
@Service
@Transactional
public class MetaService {

    private static final Logger LOG = LoggerFactory.getLogger(MetaService.class);

    private final MetaRepository metaRepository;

    public MetaService(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    /**
     * Save a meta.
     *
     * @param meta the entity to save.
     * @return the persisted entity.
     */
    public Meta save(Meta meta) {
        LOG.debug("Request to save Meta : {}", meta);
        return metaRepository.save(meta);
    }

    /**
     * Update a meta.
     *
     * @param meta the entity to save.
     * @return the persisted entity.
     */
    public Meta update(Meta meta) {
        LOG.debug("Request to update Meta : {}", meta);
        return metaRepository.save(meta);
    }

    /**
     * Partially update a meta.
     *
     * @param meta the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Meta> partialUpdate(Meta meta) {
        LOG.debug("Request to partially update Meta : {}", meta);

        return metaRepository
            .findById(meta.getId())
            .map(existingMeta -> {
                if (meta.getArea() != null) {
                    existingMeta.setArea(meta.getArea());
                }
                if (meta.getPontuacao() != null) {
                    existingMeta.setPontuacao(meta.getPontuacao());
                }

                return existingMeta;
            })
            .map(metaRepository::save);
    }

    /**
     * Get all the metas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Meta> findAll(Pageable pageable) {
        LOG.debug("Request to get all Metas");
        return metaRepository.findAll(pageable);
    }

    /**
     * Get all the metas with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<Meta> findAllWithEagerRelationships(Pageable pageable) {
        return metaRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     *
     *
     * @return the list of entities.
     */
    public Page<Meta> findAllWithArea(Pageable pageable, AreaEnem area) {
        return metaRepository.findByArea(pageable, area);
    }

    /**
     * Get one meta by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Meta> findOne(Long id) {
        LOG.debug("Request to get Meta : {}", id);
        return metaRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the meta by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete Meta : {}", id);
        metaRepository.deleteById(id);
    }
}
