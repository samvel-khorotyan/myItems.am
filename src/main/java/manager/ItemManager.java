package manager;

import db.DBConnectionProvider;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public boolean addItem(Item item) {

        String sql = "INSERT INTO item (title,price,category_id,pic_url,user_id) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, item.getTitle());
            preparedStatement.setDouble(2, item.getPrice());
            preparedStatement.setInt(3, item.getCategoryId());
            preparedStatement.setString(4, item.getPicUrl());
            preparedStatement.setInt(5, item.getUserId());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                item.setId(resultSet.getInt(1));
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Item getById(int id) {

        String sql = "SELECT * FROM item WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                return getItemFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Item getItemFromResultSet(ResultSet resultSet) {
        try {
            return Item.builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .price(resultSet.getDouble(3))
                    .categoryId(resultSet.getInt(4))
                    .picUrl(resultSet.getString(5))
                    .userId(resultSet.getInt(6))
                    .build();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Item item) {

        String sql = "UPDATE item SET title = ?,price = ?, category_id = ?, pic_url = ?, user_id = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, item.getTitle());
            preparedStatement.setDouble(2, item.getPrice());
            preparedStatement.setInt(3, item.getCategoryId());
            preparedStatement.setString(4, item.getPicUrl());
            preparedStatement.setInt(5, item.getUserId());

            preparedStatement.setInt(6, item.getId());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Item> getAllItems() {

        String sql = "select * from item";

        List<Item> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                list.add(getItemFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Item> getItemsByUserId(int id) {
        String sql = "select * from item WHERE user_id = ?";

        List<Item> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,id);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                list.add(getItemFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

//    public List<Item> getItems() {
//        String sql = "SELECT * FROM  item LIMIT 20 OFFSET 20";
//        String sql = "SELECT * FROM  item LIMIT 20 OFFSET 20";
//
//        List<Item> items = new ArrayList<>();
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                items.add(getItemFromResultSet(resultSet));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return items;
//    }

    public List<Item> getItems() {

        String sql = "SELECT * FROM item order by id desc LIMIT 20";

        List<Item> items = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                items.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public List<Item> getAllCars() {
        String sql = "select * from item WHERE category_id = ?";

        List<Item> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,1);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                list.add(getItemFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Item> getAllHouses() {
        String sql = "select * from item WHERE category_id = ?";

        List<Item> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,2);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                list.add(getItemFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Item> getAllCommercial() {
        String sql = "select * from item WHERE category_id = ?";

        List<Item> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,3);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                list.add(getItemFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Item> getAllFurniture() {
        String sql = "select * from item WHERE category_id = ?";

        List<Item> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,4);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                list.add(getItemFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
