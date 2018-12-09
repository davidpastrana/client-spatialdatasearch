package com.opendataview.web.persistence;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.opendataview.web.model.LocationModel;
import com.opendataview.web.model.RatingModel;

public interface LocationServiceDAO {

  List<LocationModel> readLocationModel() throws DataAccessException;

  void removeLocationModel(LocationModel locationModel);

  void updateLocationModel(LocationModel locationModel);

  void updateRatingModel(RatingModel ratingModel);

  void storeRatingModel(RatingModel rating);

  List<RatingModel> readRatingModel() throws DataAccessException;

  void storeLocationModel(List<LocationModel> locationlist);

}