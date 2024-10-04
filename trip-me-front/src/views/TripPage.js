import React, { memo } from "react";
import { Page } from "react-onsenui";
import { useMediaQuery } from "@material-ui/core";
import { Row, Col, Image, Modal } from "antd";
import styles from "./TripPage.module.scss";
import { TripViewModel } from "../viewmodels/TripViewModel";
import { useLocation, useNavigate } from "react-router-dom";
import TagView from "./TagView";
import Search from "antd/es/input/Search";
import { TagViewModel } from "../viewmodels/TagViewModel";
import DetailView from "./DetailView";
import { PhotoModalViewModel } from "../viewmodels/PhotoModalViewModel";
import StatusView from "./StatusView";

function TripPage() {
  const isXS = useMediaQuery("(max-width: 576px)");
  const location = useLocation();
  const navigate = useNavigate();
  const query = new URLSearchParams(location.search);
  let keyword = query.get("keyword");
  if (keyword == null) {
    keyword = "";
  }
  const { trips, loadingTrip } = TripViewModel(keyword);
  const { tags, loadingTag } = TagViewModel();
  const { photo, setPhoto, isOpenPhoto, setOpenPhoto } = PhotoModalViewModel();

  const navigateToTrips = (value) => {
    navigate("/trips?keyword=" + value);
  };

  const onSearch = (value) => {
    navigateToTrips(value);
  };

  const previewPhotos = (url) => {
    setPhoto(url);
    setOpenPhoto(true);
  };

  const handleCancel = () => {
    setOpenPhoto(false);
  };

  return (
    <div className={styles.ResponsiveContent}>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          margin: "36px 0  18px 0",
        }}
      >
        <Search
          style={{
            padding: isXS ? "0 36px 0 36px" : "0 0 0 0",
            maxWidth: "576px",
          }}
          placeholder="ค้นหา"
          allowClear
          enterButton="ค้นหา"
          size="large"
          onSearch={onSearch}
        />
      </div>
      <div style={{ display: "flex", justifyContent: "center" }}>
        <div
          style={{
            maxWidth: "576px",
            padding: isXS ? "0 36px 36px 36px" : "0 0 36px 0",
          }}
        >
          <div
            style={{
              color: "grey",
            }}
          >
            หมวดยอดนิยม:
            <TagView tags={tags} />
          </div>
        </div>
      </div>
      {!loadingTrip ? (
        trips.length > 0 ? (
          <Row gutter={[36, 36]}>
            {trips?.map((item, idx) => {
              return (
                <Col key={idx} xs={24} sm={12}>
                  {isXS ? (
                    <Col key={idx} xs={24} sm={12}>
                      <Col style={{ paddingBottom: 12 }}>
                        <Image
                          onClick={previewPhotos.bind(this, item.photos[0])}
                          width={"100%"}
                          src={item.photos[0]}
                          alt="Not found image"
                          preview={false}
                          style={{ objectFit: "cover", borderRadius: 20 }}
                        />
                      </Col>
                      <Col
                        style={{
                          display: "flex",
                          flexDirection: "column",
                          flex: 1,
                        }}
                      >
                        <div
                          style={{
                            flex: 1,
                          }}
                        >
                          <DetailView item={item} />
                        </div>
                      </Col>
                    </Col>
                  ) : (
                    <Row>
                      <Col>
                        <Image
                          onClick={previewPhotos.bind(this, item.photos[0])}
                          width={120}
                          height={215}
                          src={item.photos[0]}
                          alt="Not found image"
                          preview={false}
                          style={{ objectFit: "cover", borderRadius: 20 }}
                        />
                      </Col>
                      <Col
                        style={{
                          display: "flex",
                          flexDirection: "column",
                          flex: 1,
                        }}
                      >
                        <div
                          style={{
                            flex: 1,
                            paddingLeft: 16,
                          }}
                        >
                          <DetailView item={item} />
                        </div>
                        <Row>
                          <Col flex={1}>
                            <div
                              className={styles.ImageSmall}
                              style={{
                                backgroundImage: `url(${item.photos[1]})`,
                              }}
                              onClick={previewPhotos.bind(this, item.photos[1])}
                            ></div>
                          </Col>
                          <Col flex={1}>
                            <div
                              className={styles.ImageSmall}
                              style={{
                                backgroundImage: `url(${item.photos[2]})`,
                              }}
                              onClick={previewPhotos.bind(this, item.photos[2])}
                            ></div>
                          </Col>
                          <Col flex={1}>
                            <div
                              className={styles.ImageSmall}
                              style={{
                                backgroundImage: `url(${item.photos[3]})`,
                              }}
                              onClick={previewPhotos.bind(this, item.photos[3])}
                            ></div>
                          </Col>
                        </Row>
                      </Col>
                    </Row>
                  )}
                </Col>
              );
            })}
          </Row>
        ) : (
          <StatusView>Empty data</StatusView>
        )
      ) : (
        <StatusView>Lodding....</StatusView>
      )}
      <Modal
        open={isOpenPhoto}
        onCancel={handleCancel}
        closable={true}
        footer={null}
        centered={true}
      >
        <div style={{ padding: 12 }}>
          <Image
            width={"100%"}
            src={photo}
            alt="Not found image"
            preview={false}
            style={{ objectFit: "cover" }}
          />
        </div>
      </Modal>
    </div>
  );
}

export default memo(TripPage);
