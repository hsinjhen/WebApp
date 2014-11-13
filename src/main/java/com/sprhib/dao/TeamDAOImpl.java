package com.sprhib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTeam(Team team) {
		getCurrentSession().save(team);
	}

	public void updateTeam(Team team) {
		Team teamToUpdate = getTeam(team.getId());
		teamToUpdate.setName(team.getName());
		teamToUpdate.setRating(team.getRating());
		getCurrentSession().update(teamToUpdate);

	}

	public Team getTeam(int id) {
		Team team = (Team) getCurrentSession().get(Team.class, id);
		return team;
	}

	public void deleteTeam(int id) {
		Team team = getTeam(id);
		if (team != null)
			getCurrentSession().delete(team);
	}

	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Team searchTeamById(int id) {
		String sql = "from Team where id=" + id;
		Query query = getCurrentSession().createQuery(sql);
		List<Team> teams = query.list();
		if (!teams.isEmpty()) {
			return teams.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> searchTeamByName(String name) {
		String sql = "from Team where name like '%"+name+"%'";
		Query query = getCurrentSession().createQuery(sql);
		List<Team> teams = query.list();
		return teams;
	}
}