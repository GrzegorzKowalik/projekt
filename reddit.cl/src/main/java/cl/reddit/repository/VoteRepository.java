package cl.reddit.repository;

import cl.reddit.model.vote.Vote;

import java.util.List;

public class VoteRepository implements IRepository<Vote> {
    @Override
    public Vote findById(Long id) {
        return null;
    }

    @Override
    public List<Vote> findAll() {
        return null;
    }

    @Override
    public Vote create(Vote vote) {
        return null;
    }

    @Override
    public boolean delete(Vote vote) {
        return false;
    }

    @Override
    public boolean update(Vote vote) {
        return false;
    }
}
