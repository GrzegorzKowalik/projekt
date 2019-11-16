package cl.reddit.repository;

import cl.reddit.model.vote.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VoteRepository extends AbstractRepository<Vote> {

    private Logger log = LoggerFactory.getLogger(VoteRepository.class);

    public Vote findById(Long id) {
        return super.findById(id, Vote.class);
    }

    public List<Vote> findAll() {
        return super.findAll(Vote.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, Vote.class);
    }

    @Override
    public Vote create(Vote vote) {
        vote.setId((Long)super.create(vote));
        return vote;
    }
}
