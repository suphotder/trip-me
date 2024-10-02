import { useEffect, useState } from "react";
import useFetch, { CachePolicies } from "use-http";

export const TripViewModel = (keyword) => {
  const [trips, setTrips] = useState([]);
  const [loadingTrip, setLoadingTrip] = useState(true);

  const tripsApi = useFetch(`http://localhost:9000/api/trips`, {
    cachePolicy: CachePolicies.NO_CACHE,
  });

  useEffect(() => {
    const fetchData = async () => {
      setLoadingTrip(true);
      const res = await tripsApi.get(`?keyword=` + keyword);
      setTrips(res);
      setLoadingTrip(false);
    };

    fetchData();
  }, [keyword]);

  return { trips, loadingTrip };
};
