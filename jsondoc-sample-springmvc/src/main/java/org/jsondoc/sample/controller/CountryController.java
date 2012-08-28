package org.jsondoc.sample.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiHeader;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;
import org.jsondoc.sample.pojo.Country;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(name="country services", description="Methods for managing countries")
@Controller
@RequestMapping(value="/country")
public class CountryController {
	
	@ApiMethod(
		path="/country/get/{name}", 
		verb=ApiVerb.GET, 
		description="Gets a country with the given name",
		produces={MediaType.APPLICATION_JSON_VALUE},
		consumes={MediaType.APPLICATION_JSON_VALUE}
	)
	@ApiErrors(apierrors={
		@ApiError(code="1000", description="Country not found"),
		@ApiError(code="9000", description="Illegal argument")
	})
	@RequestMapping(value="/get/{name}", method=RequestMethod.GET)
	public @ResponseBody @ApiResponseObject Country getCountryByName(@PathVariable @ApiParam(name="name") String name) {
		// Here goes the method implementation
		return null;
	}
	
	@ApiMethod(
		path="/country/all", 
		verb=ApiVerb.GET, 
		description="Gets all the countries",
		produces={MediaType.APPLICATION_JSON_VALUE},
		consumes={MediaType.APPLICATION_JSON_VALUE}
	)
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public @ResponseBody @ApiResponseObject List<Country> getAllCountries() {
		// Here goes the method implementation
		return null;
	}
	
	@ApiMethod(
		path="/country/save", 
		verb=ApiVerb.POST, 
		description="Saves a country, with a list of cities",
		produces={MediaType.APPLICATION_JSON_VALUE},
		consumes={MediaType.APPLICATION_JSON_VALUE}
	)
	@ApiHeaders(headers={
		@ApiHeader(name="application_id", description="The application id")
	})
	@ApiErrors(apierrors={
		@ApiError(code="5000", description="Duplicate country"),
		@ApiError(code="6000", description="Validation error"),
		@ApiError(code="7000", description="Invalid application id"),
		@ApiError(code="9000", description="Illegal argument")
	})
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody @ApiResponseObject String saveCountry(@RequestBody @ApiBodyObject Country country) {
		// Here goes the method implementation
		return null;
	}

	@ApiMethod(
		path="/country/delete/{id}", 
		verb=ApiVerb.DELETE, 
		description="Deletes the country with the given id",
		produces={MediaType.APPLICATION_JSON_VALUE},
		consumes={MediaType.APPLICATION_JSON_VALUE}
	)
	@ApiHeaders(headers={
		@ApiHeader(name="application_id", description="The application id")
	})
	@ApiErrors(apierrors={
		@ApiError(code="1000", description="Country not found"),
		@ApiError(code="7000", description="Invalid application id"),
		@ApiError(code="9000", description="Illegal argument")
	})
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody @ApiResponseObject boolean deleteCountry(@PathVariable @ApiParam(name="id") Integer id) {
		// Here goes the method implementation
		return true;
	}
}
