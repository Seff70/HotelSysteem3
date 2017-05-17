package com.capgemini.repository;

import com.capgemini.Model.Boat;
import org.springframework.data.repository.CrudRepository;

public interface BoatRepository extends CrudRepository<Boat, Integer> {

}


//
////    @Autowired
////    DatabaseService databaseService;
//
//    @Autowired
//    DataSource dataSource;
//
//    public List<Boat> getAllBoats() throws SQLException {
//        ArrayList<Boat> boatList = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection()) {
//            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Boat")) {
//                try (ResultSet rs = statement.executeQuery()) {
//                    while (rs.next()) {
//                        boatList.add(mapBoat(rs));
//                    }
//                }
//            }
//        }
//        return boatList;
//    }
//
//    public Boat getBoat(int id) throws SQLException {
//        try (Connection connection = dataSource.getConnection()) {
//            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Boat WHERE BoatID = ?")) {
//                statement.setInt(1, id);
//                try (ResultSet rs = statement.executeQuery()) {
//                    if (rs.next()) {
//                        return mapBoat(rs);
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public Boat findBoat(int bootnummer) throws SQLException {
//        try (Connection connection = dataSource.getConnection()) {
//            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Boat WHERE boatnumber = ?")) {
//                statement.setInt(1, bootnummer);
//                try (ResultSet rs = statement.executeQuery()) {
//                    if (rs.next()) {
//                        return mapBoat(rs);
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private Boat mapBoat(ResultSet rs) throws SQLException {
//        int boatID = rs.getInt("BoatID");
//        int boatnumber = rs.getInt("boatnumber");
//        return new Boat(boatID, boatnumber);
//    }
//
//}
